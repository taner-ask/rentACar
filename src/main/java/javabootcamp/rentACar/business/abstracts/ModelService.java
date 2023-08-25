package javabootcamp.rentACar.business.abstracts;

import java.util.List;

import javabootcamp.rentACar.business.requests.CreateModelRequest;
import javabootcamp.rentACar.business.responses.GetAllModelsResponse;

public interface ModelService {
	List<GetAllModelsResponse> getAll();
	void add(CreateModelRequest createModelRequest);
}
