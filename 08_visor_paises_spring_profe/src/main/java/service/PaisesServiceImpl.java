/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import locator.DatosLocator;
import model.Pais;

@Service
public class PaisesServiceImpl implements PaisesService {
    
	@Autowired
	DatosLocator locator;
    
    @Override
	public List<String> continentes(){
    	return locator.streamPaises()
                .map(p->p.getContinente())
                .distinct()
                .collect(Collectors.toList());
    }
    
    @Override
	public List<Pais> paisesPorContinente(String continente){
        
            return locator.streamPaises()
                    .filter(p->p.getContinente().equals(continente))
                    .collect(Collectors.toList());
       
    }
    
    @Override
	public long poblacionContinente(String continente){
        
            return locator.streamPaises()
            	.filter(p->p.getContinente().equals(continente))
                .mapToLong(p->p.getHabitantes())
                .sum();
        
    }
}
