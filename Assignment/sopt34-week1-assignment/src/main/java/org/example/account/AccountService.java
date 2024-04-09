package org.example.account;

import javax.naming.InsufficientResourcesException;

public interface AccountService {
    void deposit(int amount);
    void withdraw(int amount) throws InsufficientResourcesException;

    Account getAccount(); // 계좌 정보를 가져오는 메서드 추가

}
