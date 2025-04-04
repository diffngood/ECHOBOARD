package echoboard.usr.main.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EchoboardUsrMainController {
	
  //@Resource(name = "mainService")
  //private EchoboardUsrMainService mainService;

  private static final Logger logger = LogManager.getLogger(EchoboardUsrMainController.class);
  
  /**
   * iframe 템플릿 
   * @param mypageVo
   * @param request
   * @param model
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "/eb/main.do")
  public String main(
		  HttpServletRequest request, ModelMap model) throws Exception {
	  
	  logger.debug("Logger Debug Test >> Controller Name: main");
      logger.info("Logger Info Test >> Controller Name: main");
      logger.error("Logger Error Test >> Controller Name: main");
	  
	  return "/eb/main";
  }
}