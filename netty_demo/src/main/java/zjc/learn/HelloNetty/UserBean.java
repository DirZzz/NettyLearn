package zjc.learn.HelloNetty;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Sandu
 * @ClassName UserBean
 * @date 2019/2/2-11:31$
 */

@Data
@AllArgsConstructor
public class UserBean implements Serializable {

	private String name;
	private Integer age;
}
