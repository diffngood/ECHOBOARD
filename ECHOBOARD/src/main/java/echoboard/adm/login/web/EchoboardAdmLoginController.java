package echoboard.adm.login.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EchoboardAdmLoginController {
	
  //@Resource(name = "mainService")
  //private EchoboardUsrMainService mainService;

  private static final Logger logger = LogManager.getLogger(EchoboardAdmLoginController.class);
  
  /**
   * iframe 템플릿 
   * @param mypageVo
   * @param request
   * @param model
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "/adm/login.do")
  public String login(
		  HttpServletRequest request, ModelMap model) throws Exception {
	  
	  logger.debug("Logger Debug Test >> Controller Name: login");
      logger.info("Logger Info Test >> Controller Name: login");
      logger.error("Logger Error Test >> Controller Name: login");
	  
	  return "/adm/login";
  }
}