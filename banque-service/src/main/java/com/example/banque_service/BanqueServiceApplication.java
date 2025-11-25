package com.example.banque_service;
import com.example.banque_service.entities.Transaction;
import com.example.banque_service.entities.TypeTransaction;
import com.example.banque_service.repositories.TransactionRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.banque_service.entities.Compte;
import com.example.banque_service.entities.TypeCompte;
import com.example.banque_service.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Date;

@SpringBootApplication
public class BanqueServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BanqueServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository,
                            TransactionRepository transactionRepository) {

        return args -> {

            // -------------------------
            // Create Accounts
            // -------------------------
            Compte c1 = compteRepository.save(
                    Compte.builder()
                            .solde(9800.0)
                            .dateCreation(new Date())
                            .type(TypeCompte.COURANT)
                            .build()
            );

            Compte c2 = compteRepository.save(
                    Compte.builder()
                            .solde(15000.0)
                            .dateCreation(new Date())
                            .type(TypeCompte.EPARGNE)
                            .build()
            );

            Compte c3 = compteRepository.save(
                    Compte.builder()
                            .solde(7500.0)
                            .dateCreation(new Date())
                            .type(TypeCompte.COURANT)
                            .build()
            );

            // -------------------------
            // Add Transactions for c1
            // -------------------------
            transactionRepository.save(
                    Transaction.builder()
                            .montant(1200.0)
                            .date(new Date())
                            .type(TypeTransaction.DEPOT)
                            .compte(c1)
                            .build()
            );

            transactionRepository.save(
                    Transaction.builder()
                            .montant(300.0)
                            .date(new Date())
                            .type(TypeTransaction.RETRAIT)
                            .compte(c1)
                            .build()
            );

            // -------------------------
            // Add Transactions for c2
            // -------------------------
            transactionRepository.save(
                    Transaction.builder()
                            .montant(5000.0)
                            .date(new Date())
                            .type(TypeTransaction.DEPOT)
                            .compte(c2)
                            .build()
            );

            // -------------------------
            // Add Transactions for c3
            // -------------------------
            transactionRepository.save(
                    Transaction.builder()
                            .montant(800.0)
                            .date(new Date())
                            .type(TypeTransaction.RETRAIT)
                            .compte(c3)
                            .build()
            );
        };
    }
}
