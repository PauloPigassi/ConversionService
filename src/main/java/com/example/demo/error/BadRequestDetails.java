package com.example.demo.error;

import java.time.LocalDateTime;

/**
 * Field details for {@link com.paulopigassi.conversordemoedas.error.BadRequestException} exception class
 * @author Paulo Pigassi
 */
public class BadRequestDetails {
    private String title;
    private int status;
    private String detail;
    private LocalDateTime timestamp;
    private String developerMessage;

    private BadRequestDetails() {

    }

    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public String getDetail() {
        return detail;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public static final class BadRequestDetailsBuilder {
        private String title;
        private int status;
        private String detail;
        private LocalDateTime timestamp;
        private String developerMessage;

        private BadRequestDetailsBuilder() {
        }

        public static BadRequestDetailsBuilder newBuilder() {
            return new BadRequestDetailsBuilder();
        }

        public BadRequestDetailsBuilder title(String title) {
            this.title = title;
            return this;
        }

        public BadRequestDetailsBuilder status(int status) {
            this.status = status;
            return this;
        }

        public BadRequestDetailsBuilder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public BadRequestDetailsBuilder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public BadRequestDetailsBuilder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public BadRequestDetails build() {
            BadRequestDetails badRequestDetails = new BadRequestDetails();
            badRequestDetails.title = this.title;
            badRequestDetails.developerMessage = this.developerMessage;
            badRequestDetails.timestamp = this.timestamp;
            badRequestDetails.status = this.status;
            badRequestDetails.detail = this.detail;
            return badRequestDetails;
        }
    }
}
