package br.com.pagonline.saldo;

import org.springframework.data.jpa.repository.JpaRepository;

interface SaldoRepository extends JpaRepository<Saldo, Long> {
}
