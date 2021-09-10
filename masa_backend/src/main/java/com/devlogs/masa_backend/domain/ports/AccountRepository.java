package com.devlogs.masa_backend.domain.ports;

import com.devlogs.masa_backend.domain.ports.dto.AccountDto;

public interface AccountRepository {
     AccountDto getAccountByEmail (String email);
}
