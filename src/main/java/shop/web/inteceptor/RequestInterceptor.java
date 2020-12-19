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
        return true;
    }

    private String getCurrentTime() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy 'at' hh:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return formatter.format(calendar.getTime());
    }
}
