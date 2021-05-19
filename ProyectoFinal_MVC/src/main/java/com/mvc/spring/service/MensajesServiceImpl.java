package com.mvc.spring.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mvc.spring.model.Mensaje;
/**
 * <p><b> Nombre </b> Clase Servicios de Mensaje</p>
 * 
 * <p><strong>Descripcion </strong> Bussines logic de mensajes, recoge formatos JSON y devuelve objetos java</p>
 * 
 * @author	Yelder Da Silva
 * 
 * @version	v1
 * 
 * @since	16/05/2021
 */
@Service
public class MensajesServiceImpl implements MensajesService{
	
	private final Logger log = LoggerFactory.getLogger(MensajesServiceImpl.class);
	
	@Override
	public Collection<Mensaje> getMensajes() {
		log.info("------------------------------Rest Template getMensajes");
		RestTemplate restTemplate = new RestTemplate();
		Mensaje[] mensajes = restTemplate.getForObject("http://localhost:5000/mensaje", Mensaje[].class);
		    List<Mensaje> listaMensajes = Arrays.asList(mensajes);
		    System.out.println(listaMensajes);
		    return listaMensajes;
	}
	
	@Override
	public Mensaje addMensajes(Mensaje mensaje) {
		log.info("------------------------------Rest Template addMensajes");
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject("http://localhost:5000/mensaje/admin/post", mensaje, Mensaje.class);
	}
	
}
