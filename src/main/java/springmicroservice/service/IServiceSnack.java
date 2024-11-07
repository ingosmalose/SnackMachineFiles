package springmicroservice.service;

import java.util.List;
import springmicroservice.model.Snack;

public interface IServiceSnack {
    
    void AddSnack(Snack snack);
    
    void ShowSnacks();
    
    List<Snack> GetSnack();
    
}
