    package peaksoft.config;

    import org.jspecify.annotations.Nullable;
    import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
    public class DispatcherServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
        @Override
        protected Class<?>[] getRootConfigClasses() {
            return new Class[]{HibernateConfig.class};
        }

        @Override
        protected Class<?> @Nullable [] getServletConfigClasses() {
            return new Class[]{WebAppConfig.class};
        }

        @Override
        protected String[] getServletMappings() {
            return new String[]{"/"};
        }
    }
