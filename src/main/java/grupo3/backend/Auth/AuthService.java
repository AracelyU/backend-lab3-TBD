package grupo3.backend.Auth;

import grupo3.backend.Entities.ProfileEntity;
import grupo3.backend.Entities.UserAddressEntity;
import grupo3.backend.repositories.ProfileRepository;
import grupo3.backend.repositories.UserAddressRepository;
import grupo3.backend.repositories.UserRepository;
import grupo3.backend.Entities.UserEntity;
import grupo3.backend.Jwt.JwtService;
import grupo3.backend.Triggers.triggerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final triggerService triggerService;
    private final UserAddressRepository userAddressRepository;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = userRepository.findByUsername(request.getUsername()).stream().findFirst().orElseThrow();

        Integer user_id = userRepository.findByUsername(request.getUsername()).stream().findFirst().orElseThrow().getId_user();

        triggerService.updateUserInLoginIdentification(user_id);

        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).size() != 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "existing user");
        }

        String[] name = request.name.split(" ");
        ProfileEntity profile = ProfileEntity.builder()
                .first_name(name[0])
                .first_lastname(name[1])
                .build();

        UserAddressEntity address = UserAddressEntity.builder()
                .build();

        Integer profileId = profileRepository.save(profile);

        Long addressId = userAddressRepository.createUserAddress(address);

        UserEntity user = UserEntity.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .id_role(3)
                .id_profile(profileId)
                .id_address_u(addressId)
                .build();

        userRepository.save(user);

        Integer user_id = userRepository.findByUsername(request.getUsername()).stream().findFirst().orElseThrow().getId_user();

        triggerService.updateUserInLoginIdentification(user_id);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
