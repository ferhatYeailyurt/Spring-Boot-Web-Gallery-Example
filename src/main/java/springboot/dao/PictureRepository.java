package springboot.dao;

import org.springframework.data.repository.CrudRepository;

import springboot.model.Picture;

public interface PictureRepository extends CrudRepository<Picture, Integer> {

}
