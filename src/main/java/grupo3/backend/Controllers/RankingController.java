package grupo3.backend.Controllers;


import grupo3.backend.Entities.InstitutionEntity;
import grupo3.backend.Entities.RankingEntity;
import grupo3.backend.Services.InstitutionService;
import grupo3.backend.Services.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/ranking")
public class RankingController {
    @Autowired
    RankingService rankingService;

    @GetMapping("/get")
    public List<RankingEntity> getAll(){
        return rankingService.getAllRankings();
    }

    @GetMapping("/get/{id}")
    public List<RankingEntity> getById(@PathVariable long id) {
        return rankingService.getRankingById(id);
    }

    @PostMapping("/post")
    @ResponseBody
    public ResponseEntity<RankingEntity> save(@RequestBody RankingEntity rankingEntity){
        long idGenerado = rankingService.createRanking(rankingEntity);
        rankingEntity.setId_ranking(idGenerado);
        return ResponseEntity.status(HttpStatus.CREATED).body(rankingEntity);
    }

    @PutMapping("/put/{id}")
    @ResponseBody
    public String update(@PathVariable long id, @RequestBody RankingEntity rankingEntity) {
        return rankingService.updateRanking(rankingEntity, id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        return rankingService.deleteRanking(id);
    }

    @GetMapping("/task_information/{id}")  // (1)
    public Map<String, Object> getTask_information(@PathVariable long id){
        return rankingService.getTaskInformation(id);
    }

    @GetMapping("/tasks_information")
    public List<Map<String, Object>> getInformationByTasks(){
        return rankingService.getInformationByTasks();
    }
}
