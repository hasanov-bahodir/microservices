package uz.paybek.notification;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

// Bahodir Hasanov 9/22/2022 6:21 PM
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
@Entity
public class Notification {
    @Id
    @SequenceGenerator(name = "fraud_id_sequence",
            sequenceName = "fraud_id_sequence"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "fraud_id_sequence"
    )
    private Integer notificationId;
    private Integer toCostumerId;
    private String toCostumerEmail;
    private String sender;
    private String message;
    private LocalDateTime sentAt;
}
