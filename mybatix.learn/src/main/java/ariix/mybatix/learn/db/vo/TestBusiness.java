package ariix.mybatix.learn.db.vo;

import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TestBusiness {
	private Integer userId;
	private List<Integer> business;
}
