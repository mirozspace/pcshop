package shop.web.inteceptor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import shop.tools.FileTools;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static shop.constants.FilePaths.FILE_LOG_PATH;

@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

    private final List<String> logs;
    private final Logger logger;
    private final FileTools fileTools;

    public RequestInterceptor(FileTools fileTools) {
        this.fileTools = fileTools;
        this.logs = new ArrayList<>();
        this.logger = LoggerFactory.getLogger(RequestInterceptor.class);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String msg = request.getRemoteAddr() + " accessed resource " + request.getRequestURI() + " @ " + getCurrentTime();
        this.logs.add(msg);
        this.logger.info(msg); //for review!
        this.fileTools.writeInLogFile(this.logs, FILE_LOG_PATH);
        this.logs.clear();

        //long startTime = System.currentTimeMillis();
        //request.setAttribute("startTime", startTime);

        /*if (request.getRemoteAddr().startsWith("192")) {
            response.sendRedirect("/auth-failed");
            return false;
        }*/
        return true;
    }

    private String getCurrentTime() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy 'at' hh:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return formatter.format(calendar.getTime());
    }

    /*@Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info(String.format("%n --- LogInteceptor postHandle (Start) --- "));
        logger.info("Request Processing ends " + getCurrentTime());
        logger.info(String.format("%n --- LogInteceptor postHandle (End) --- "));

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info(String.format("%n --- LogInteceptor postHandle after view in rendered (Start) --- "));
        long endTime = System.currentTimeMillis();
        long startTime = Long.parseLong(request.getAttribute("startTime") + "");
        logger.info("Total time taken to process request (in milliseconds(ms)) "
            + (endTime - startTime) + " ms");
        logger.info(String.format("%n --- LogInteceptor postHandle after view in rendered (End) --- "));
    }*/



}
