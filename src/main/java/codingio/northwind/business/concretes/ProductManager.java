package codingio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; //beans = project class   factory = dependency injection runs factory design pattern in the background so it is instance. 
import org.springframework.stereotype.Service;

import codingio.northwind.business.abstracts.ProductService;
import codingio.northwind.core.utilities.results.DataResult;
import codingio.northwind.core.utilities.results.Result;
import codingio.northwind.core.utilities.results.SuccessDataResult;
import codingio.northwind.core.utilities.results.SuccessResult;
import codingio.northwind.dataAccess.abstracts.ProductDao;
import codingio.northwind.entities.concretes.Product;

@Service //It gives information to Spring that the class runs as a service duty.
public class ProductManager implements ProductService{
	
	private ProductDao productDao;
	@Autowired //Spring will create a class corresponding to the instances of ProductDao in the background. It is so common. It usually creates dependency. @Autowired(injection)  finds the class corresponding to the stated interface of all projects.
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {

		return new SuccessDataResult<List<Product>>(this.productDao.findAll(), "Data Listed.");
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Product added");
	}

}