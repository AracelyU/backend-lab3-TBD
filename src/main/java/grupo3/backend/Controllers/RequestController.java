package grupo3.backend.Controllers;

import grupo3.backend.Entities.RequestEntity;
import grupo3.backend.Services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping ("/request")
public class RequestController {

        @Autowired
        RequestService requestService;

        // GET
        @GetMapping("/get")
        public List<RequestEntity> getAll(){
            return requestService.getAllRequest();
        }

        @GetMapping("/get/{id}")
        public List<RequestEntity> getById(@PathVariable long id) {
            return requestService.getRequestById(id);
        }

        // POST
        @PostMapping("/post")
        @ResponseBody
        public ResponseEntity<RequestEntity> save(@RequestBody RequestEntity requestEntity){
            long idGenerado = requestService.createRequest(requestEntity);
            requestEntity.setId_request(idGenerado);
            return ResponseEntity.status(HttpStatus.CREATED).body(requestEntity);
        }

        // PUT
        @PutMapping("/put/{id}")
        @ResponseBody
        public String update(@PathVariable long id, @RequestBody RequestEntity requestEntity) {
            return requestService.updateRequest(requestEntity, id);
        }

        // DELETE
        @DeleteMapping("/delete/{id}")
        public String delete(@PathVariable long id) {
            return requestService.deleteRequest(id);
        }

        @GetMapping("/get_request_names")
        public List<Map<String, Object>> getRequestNames(){
            return requestService.get_request_names();
        }
}
