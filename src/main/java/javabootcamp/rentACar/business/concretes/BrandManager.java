package javabootcamp.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import javabootcamp.rentACar.business.abstracts.BrandService;
import javabootcamp.rentACar.business.requests.CreateBrandRequest;
import javabootcamp.rentACar.business.requests.UpdateBrandRequest;
import javabootcamp.rentACar.business.responses.GetAllBrandsResponse;
import javabootcamp.rentACar.business.responses.GetByIdBrandResponse;
import javabootcamp.rentACar.business.rules.BrandBusinessRules;
import javabootcamp.rentACar.core.utilities.mappers.ModelMapperService;
import javabootcamp.rentACar.dataAccess.abstracts.BrandRepository;
import javabootcamp.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service  // bu sınıf bir Business nesnesidir
@AllArgsConstructor
public class BrandManager implements BrandService {

	private BrandRepository brandRepository;   //polymorphism e uygun olması için burada tanımlıyoruz
	private ModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;

	@Override
	public List<GetAllBrandsResponse> getAll() {
		
		List<Brand> brands = brandRepository.findAll();
//		List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();
//		
//		for (Brand brand : brands) {
//			GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
//			responseItem.setId(brand.getId());
//			responseItem.setName(brand.getName());
//			
//			brandsResponse.add(responseItem);
//		}
		
		List<GetAllBrandsResponse> brandsResponse = brands.stream()
				.map(brand->this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
		
		
		// iş kuralları
		return brandsResponse;
	}


	@Override
	public void add(CreateBrandRequest createBrandRequest) {
//		Brand brand = new Brand();
//		brand.setName(createBrandRequest.getName()); //teker teker set işlemini yazmamak için mapper kullandık
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
		
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		
		this.brandRepository.save(brand);
	}


	@Override
	public GetByIdBrandResponse getByIdBrandResponse(int id) {
		Brand brand = this.brandRepository.findById(id).orElseThrow();
		
		GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
		
		return response;
	}


	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand);
	}


	@Override
	public void delete(int id) {
		this.brandRepository.deleteById(id);
		
	}

}
