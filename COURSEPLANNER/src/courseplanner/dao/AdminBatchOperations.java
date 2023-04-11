package courseplanner.dao;

import java.util.List;

import courseplanner.dto.Batch;
import exceptions.BatchException;
import exceptions.FacultyException;
import exceptions.SomethingWentWrong;

public interface AdminBatchOperations {
	
	public void createBatch(Batch batch) throws SomethingWentWrong, BatchException;
	
	public void updateBatch(Batch batch) throws SomethingWentWrong, BatchException;
	
	public List<Batch> viewAllBatches() throws SomethingWentWrong, BatchException;
	
	public List<Batch> viewBatch(String batch_id) throws SomethingWentWrong, BatchException;

	public void allocateFacultytoBatch(String batch_id, String faculty_id) throws SomethingWentWrong, BatchException, FacultyException;

}
