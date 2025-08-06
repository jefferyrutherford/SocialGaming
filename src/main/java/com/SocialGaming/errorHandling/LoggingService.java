package com.SocialGaming.errorHandling;

import com.SocialGaming.logging.model.ErrorLogs;
import com.SocialGaming.logging.repository.ErrorLogsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoggingService {
    private final ErrorLogsRepository errorRepository;


    public LoggingService(ErrorLogsRepository errorRepository){
        this.errorRepository = errorRepository;
    };


    public void saveErrorLog(ErrorResponse errorResponse) {
        Optional<ErrorLogs> found = this.errorRepository.getErrorByErrorMessageAndApiLink(errorResponse.getMessage(), errorResponse.getDetails());

        if (found.isPresent()) {
            ErrorLogs exist = found.get();
            exist.setCount(exist.getCount() + 1);
            this.errorRepository.save(exist);
        }
        else {
            ErrorLogs newError = new ErrorLogs();
            newError.setApiLink(errorResponse.getDetails());
            newError.setErrorMessage(errorResponse.getMessage());
            errorRepository.save(newError);
        }

    }

}
