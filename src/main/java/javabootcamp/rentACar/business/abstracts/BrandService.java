package javabootcamp.rentACar.business.abstracts;

import java.util.List;

import javabootcamp.rentACar.business.requests.CreateBrandRequest;
import javabootcamp.rentACar.business.requests.UpdateBrandRequest;
import javabootcamp.rentACar.business.responses.GetAllBrandsResponse;
import javabootcamp.rentACar.business.responses.GetByIdBrandResponse;

public interface BrandService {
	List<GetAllBrandsResponse> getAll();
	GetByIdBrandResponse getByIdBrandResponse(int id);
	void add(CreateBrandRequest createBrandRequest);
	void update(UpdateBrandRequest updateBrandRequest);
	void delete(int id);
}
