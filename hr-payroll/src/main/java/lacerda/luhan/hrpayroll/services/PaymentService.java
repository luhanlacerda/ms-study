package lacerda.luhan.hrpayroll.services;

import lacerda.luhan.hrpayroll.entities.Payment;
import lacerda.luhan.hrpayroll.entities.Worker;
import lacerda.luhan.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workId, int days) {

        try {
            Worker worker = workerFeignClient.findById(workId).getBody();
            Payment payment = worker != null ? new Payment(worker.getName(), worker.getDailyIncome(), days) : null;

            return payment;
        } catch (Exception e) {
            //TODO loggar
            return null;
        }
    }

}
