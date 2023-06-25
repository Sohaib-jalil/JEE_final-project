package com.sohaib.e_bankbackend;

import com.sohaib.e_bankbackend.dtos.BankAccountDTO;
import com.sohaib.e_bankbackend.dtos.CurrentBankAccountDTO;
import com.sohaib.e_bankbackend.dtos.CustomerDTO;
import com.sohaib.e_bankbackend.dtos.SavingBankAccountDTO;
import com.sohaib.e_bankbackend.entities.*;
import com.sohaib.e_bankbackend.enums.AccountStatus;
import com.sohaib.e_bankbackend.enums.OperationType;
import com.sohaib.e_bankbackend.exceptions.BalanceNotSufficientExeption;
import com.sohaib.e_bankbackend.exceptions.BankAccountNotFoundException;
import com.sohaib.e_bankbackend.exceptions.CustomerNotFoundException;
import com.sohaib.e_bankbackend.repositories.AccountOperationRepository;
import com.sohaib.e_bankbackend.repositories.BankAccountRepository;
import com.sohaib.e_bankbackend.repositories.CustomerRepository;
import com.sohaib.e_bankbackend.services.BankAccountService;
import com.sohaib.e_bankbackend.services.BankService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EBankBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EBankBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountService bankAccountService){
        return args -> {
            Stream.of("Hassan", "Imane", "Mohemed").forEach(name -> {
                CustomerDTO customerDTO = new CustomerDTO();
                customerDTO.setName(name);
                customerDTO.setEmail(name + "@gmail.com");
                bankAccountService.saveCustomer(customerDTO);
            });
            bankAccountService.listCustomers().forEach(customer -> {

                try {
                    bankAccountService.saveCurrentBankAccount(Math.random()*90000, customer.getId(), 9000);
                    bankAccountService.saveSavingBankAccount(Math.random()*90000, customer.getId(), 5.5);

                } catch (CustomerNotFoundException e) {
                    e.printStackTrace();
                }

            });
            List<BankAccountDTO> bankAccounts = bankAccountService.bankAccountList();
            for (BankAccountDTO bankAccount : bankAccounts){
                for (int i = 0; i<10; i++){
                    String accountId;
                    if (bankAccount instanceof SavingBankAccountDTO){
                        accountId = ((SavingBankAccountDTO) bankAccount).getId();
                    } else {
                        accountId = ((CurrentBankAccountDTO) bankAccount).getId();
                    }
                    bankAccountService.credit(accountId, 10000+Math.random()*120000, "Credit");
                    bankAccountService.debit(accountId, 1000+Math.random()*9000, "Debit");
                }
            }
        };
    }
//    @Bean
    CommandLineRunner start(CustomerRepository customerRepository,
                            BankAccountRepository bankAccountRepository,
                            AccountOperationRepository accountOperationRepository){
        return args -> {
            Stream.of("Hassan", "Yassine", "Aicha").forEach(name -> {
                Customer customer = new Customer();
                customer.setName(name);
                customer.setEmail(name + "@gmail.com");
                customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(cust -> {
                CurrentAccount currentAccount = new CurrentAccount();
                currentAccount.setId(UUID.randomUUID().toString());
                currentAccount.setBalance(Math.random()*90000);
                currentAccount.setCreatedAt(new Date());
                currentAccount.setStatus(AccountStatus.CREATED);
                currentAccount.setCustomer(cust);
                currentAccount.setOverDraft(9000);
                bankAccountRepository.save(currentAccount);

                SavingAccount savingAccount = new SavingAccount();
                savingAccount.setId(UUID.randomUUID().toString());
                savingAccount.setBalance(Math.random()*90000);
                savingAccount.setCreatedAt(new Date());
                savingAccount.setStatus(AccountStatus.CREATED);
                savingAccount.setCustomer(cust);
                savingAccount.setInterestRate(5.5);
                bankAccountRepository.save(savingAccount);
            });
            bankAccountRepository.findAll().forEach(acc -> {
                for (int i = 0; i < 5; i++){
                    AccountOperation accountOperation = new AccountOperation();
                    accountOperation.setOperationDate(new Date());
                    accountOperation.setAmount(Math.random()*12000);
                    accountOperation.setType(Math.random() > 0.5? OperationType.DEBIT: OperationType.CREDIT);
                    accountOperation.setBankAccount(acc);
                    accountOperationRepository.save(accountOperation);
                }

            });
        };
    }

}
