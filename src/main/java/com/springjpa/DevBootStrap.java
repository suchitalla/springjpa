package com.springjpa;


import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.springjpa.entities.Magazines;
import com.springjpa.entities.Publisher;
import com.springjpa.repository.MagazineRepository;
import com.springjpa.repository.PublisherRepository;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

	//@Autowired
	private PublisherRepository publisher;
	public DevBootStrap(PublisherRepository publisher, MagazineRepository magazine) {
		super();
		this.publisher = publisher;
		this.magazine = magazine;
	}

	//@Autowired
	private MagazineRepository magazine;
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		init();
	}
	
	private void init() {
		
		Publisher pub = new Publisher();
		pub.setName("tomken");
		Magazines mag = new Magazines();
		mag.setName("economist");
		pub.getMagazines().add(mag);
		mag.getPublishers().add(pub);
		magazine.save(mag);
		publisher.save(pub);
		
		
		
		Publisher pub2 = new Publisher();
		pub2.setName("tim");
		Magazines mag2 = new Magazines();
		mag2.setName("hello");
		pub2.getMagazines().add(mag2);
		mag2.getPublishers().add(pub2);
		magazine.save(mag2);
		publisher.save(pub2);

	}

}
