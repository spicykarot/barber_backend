package com.man.barber.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.man.barber.entity.MsBarberShop;
import com.man.barber.model.BarberShopModel;

public interface BarberShopRepository extends JpaRepository<MsBarberShop,Long>{
	
	public List<MsBarberShop> findAll();

	@Query("select new com.man.barber.model.BarberShopModel("
			+ "b.id "
			+ ",b.name "
			+ ",b.address "
			+ ",b.tel "
			+ ",b.image "
			+ ",b.barberOwnerId.id ) "
			+ "from MsBarberShop b "
			+ "where (:name is null or b.name like %:name% ) and "
			+ "(:address is null or b.address like %:address% )")
	Page<BarberShopModel> findAllFilterWithPagingAndSearching(@Param("name") String name, @Param("address") String address,
			Pageable pageable);
	
}
