package test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.resource.jdbc.LogicalConnection;

import entity.Category;
import entity.Manufacture;
import entity.Product;
import util.HibernateUtil;
import util.HibernateUtil111;

public class HibernateTest {
	public static void main(String[] args) {
		Session session = HibernateUtil.getFactory().openSession();
		session.beginTransaction();
//			Category c1 = new Category();
//			c1.setName(điện thoại");
//			c1.setDescription("dien thoai");
//			session.save(c1);
//			Product p = new Product();
//			p.setName("iphone 12");
//			p.setPrice(new BigDecimal(2000));
//			Category c = session.get(Category.class, 1);
//			p.setCategory(c);
//			
//			session.save(p);

		// ManyToOne defaulf fetchType.EAGER
//			Product p = session.get(Product.class, 3);
//			System.out.println(p.getName());
//			Category c = p.getCategory();
//			System.out.println(c.getName());

		// OneToMany defaul fetchType.LAZY
//			Category c = session.get(Category.class, 1);
//			List<Product> products = c.getProducts();
//			for(Product product:products ) {
//				System.out.println(product.getName());
//			}

		// ManyToMany defaul fetchType.LAZY--- product --> manufacture

//			Product p = session.get(Product.class, 1);
//			List<Manufacture> manufactures = new ArrayList<Manufacture>();
//			manufactures.add(session.get(Manufacture.class, 1));
//			manufactures.add(session.get(Manufacture.class, 2));
//			p.setManufactures(manufactures);
//			session.save(p);

		// ManyToMany manufacture --> product
//			Manufacture man = session.get(Manufacture.class, 1);
//			man.getProducts().forEach(p -> System.out.printf("%d - %s\n", p.getId(), p.getName()));

		// ----------HQL-------------

		// ----------HQL FROM --------
//		String hql = "from  Product";
//		javax.persistence.Query query = session.createQuery(hql);
//		List<Product> products = query.getResultList();
//		products.forEach(p -> System.out.printf(" %s\n", p.getName()));

		// ---------HQL SELECT---------
//		String hql = "select p.price from Product p";
//		javax.persistence.Query query = session.createQuery(hql);
//		List<BigDecimal> bigDecimals = query.getResultList();
//		bigDecimals.forEach(b -> System.out.printf(" %d\n", b.toBigInteger()));

		// ----------HQL SELECT-------
//		String hql = "select p.category from Product p";
//		javax.persistence.Query query = session.createQuery(hql);
//		List<Category> categories = query.getResultList();
//		categories.forEach(c -> System.out.printf(" %s\n", c.getName()));

		// --------HQL WHERE ----------
//		String hql = "from  Product p where p.id = 3 ";
//		javax.persistence.Query query = session.createQuery(hql);
//		List<Product> products = query.getResultList();
//		products.forEach(p -> System.out.printf(" %s\n", p.getName()));
//		
		// --------HQL ORDER BY ----------
//		String hql = "from  Product p order by  p.price desc";
//		javax.persistence.Query query = session.createQuery(hql);
//		List<Product> products = query.getResultList();
//		products.forEach(p -> System.out.printf(" %s-- %d\n", p.getName(), p.getPrice().toBigInteger()));

		// --------HQL GROUP BY ----------
//		String hql =  " select p.category, count(p.category) from  Product p group by p.category ";
//		String hql = "select p.price, count(p.price) from Product p group by p.price ";
//		javax.persistence.Query query = session.createQuery(hql);
//		List<Object[]> list = query.getResultList();

//		list.forEach(item -> System.out.println(Category.class.cast(item[0]).getName() + "\t count : " + item[1]));
//		list.forEach(item -> System.out.println(item[0] + "\t count : " + item[1]));

		// --------HQL UPDATE --------
//		String hql = "UPDATE Product set price = :price " + "WHERE id = :product_id";
//		javax.persistence.Query query = session.createQuery(hql);
//		query.setParameter("price", new BigDecimal(5000));
//		query.setParameter("product_id", 5 );
//		int result = query.executeUpdate();
//		System.out.println("Rows affected: " + result);

		// --------HQL Phân trang -----------
//		
//		String hql = "from Product";
//		javax.persistence.Query query = session.createQuery(hql);
//		query.setFirstResult(0);
//		query.setMaxResults(3);
//		List<Product> products = query.getResultList();
//		products.forEach(p -> System.out.printf(" %s-- %d\n",p.getName(),p.getPrice().toBigInteger()));

		// --------CRITERIA------------------
//		@SuppressWarnings("deprecation")
//		Criteria cr = session.createCriteria(Product.class);

		// select all 
//		cr.addOrder(Order.asc("price"));
//		List<Product> products = cr.list();
//		products.forEach(p -> System.out.printf(" %s-- %d\n", p.getName(), p.getPrice().toBigInteger()));

		// select product có price > 3000
//		cr.add(Restrictions.gt("price", new BigDecimal(3000)));
//		List<Product> products = cr.list();
//		products.forEach(p -> System.out.printf(" %s-- %d\n", p.getName(), p.getPrice().toBigInteger()));

		// select product có name bắt đầu bằng iphone
//		cr.add(Restrictions.like("name", "iphone%"));
//		List<Product> products = cr.list();
//		products.forEach(p -> System.out.printf(" %s-- %d\n", p.getName(), p.getPrice().toBigInteger()));


		// select product có name chứa chuỗi iphone ở vị trí bất kỳ and price < 3000
//		Criterion name = Restrictions.ilike("name", "%iphone%");
//		Criterion price = Restrictions.lt("price", new BigDecimal(3000));
//		LogicalExpression andExp = Restrictions.and(name, price);
//		cr.add(andExp);
//		List<Product> products = cr.list();
//		products.forEach(p -> System.out.printf(" %s-- %d\n", p.getName(), p.getPrice().toBigInteger()));

		// Lấy tổng số hàng.
//		cr.setProjection(Projections.rowCount());
//		List list = cr.list();
//		System.out.println(list.get(0) );
		
		// Lấy giá trị trung bình của một thuộc tính.
//		cr.setProjection(Projections.avg("price"));
//		List list = cr.list();
//		System.out.println(list.get(0) );

		// Để có số lần xuất hiện duy nhât của một thuộc tính.
//		cr.setProjection(Projections.countDistinct("name"));
//		List list = cr.list();
//		System.out.println(list.get(0) );

		// Lấy giá trị maximum của một thuộc tính.
//		cr.setProjection(Projections.max("price"));
//		List list = cr.list();
//		System.out.println(list.get(0) );

		// Lấy giá trị minimum của một thuộc tính.
//		cr.setProjection(Projections.min("price"));
//		List list = cr.list();
//		System.out.println(list.get(0) );

		// Lấy tổng các giá trị của một thuộc tính
//		cr.setProjection(Projections.sum("price"));
//		List list = cr.list();
//		System.out.println(list.get(0) );

		

		session.getTransaction().commit();
		session.close();
	}

}
