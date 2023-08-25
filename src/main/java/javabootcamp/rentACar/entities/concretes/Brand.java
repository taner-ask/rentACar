package javabootcamp.rentACar.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="brands")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity  // bu sınıfın veritabanında bir tabloya karşılık geleceğini belirtirsiniz
public class Brand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//id otomatik artar
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy = "brand") //brand instans üyesi ile ilişkilendir
	private List<Model> models;
	
}
