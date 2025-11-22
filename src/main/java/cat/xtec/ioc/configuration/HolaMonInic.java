package cat.xtec.ioc.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class HolaMonInic  extends AbstractAnnotationConfigDispatcherServletInitializer {
@Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { HolaMonConfiguracio.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
