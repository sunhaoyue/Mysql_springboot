import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: Sqlserver_springboot
 * @description: ${description}
 * @author: Sunhaoyue
 * @create: 2019/06/19 13:26
 */

@Controller
public class ErrorController {


    @RequestMapping("/error")
    public String error() {
        return "error";
    }


}
