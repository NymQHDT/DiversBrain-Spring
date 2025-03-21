// package com.diversBrain.service;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;

// import com.diversBrain.models.Symptoms;
// import com.diversBrain.models.User;
// import com.diversBrain.repository.SymptomsRepository;

// public class SymptomService {
//   @Autowired
//     private SymptomsRepository symptomRepository;
    
//     public Symptoms saveSymptom(Symptoms symptom, User currentUser) {
//         symptom.setUser(currentUser);
//         return symptomRepository.save(symptom);
//     }
    
//     // Méthode pour récupérer tous les symptômes d'un utilisateur
//     public List<Symptoms> getSymptomsByUser(User user) {
//         return symptomRepository.findByUser(user);
//     }
// }
