package uz.paybek.notification;
// Bahodir Hasanov 9/22/2022 6:35 PM

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Integer> {
}
