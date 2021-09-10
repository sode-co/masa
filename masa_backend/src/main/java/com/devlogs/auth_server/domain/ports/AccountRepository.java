package com.devlogs.auth_server.domain.ports;

import com.devlogs.auth_server.domain.ports.dto.AccountDto;

public interface AccountRepository {
     AccountDto getAccountByEmail (String email);
}
