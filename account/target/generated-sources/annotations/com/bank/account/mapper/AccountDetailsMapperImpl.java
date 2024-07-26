package com.bank.account.mapper;

import com.bank.account.dto.AccountDetailsDto;
import com.bank.account.entity.AccountDetails;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-26T18:01:18+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class AccountDetailsMapperImpl implements AccountDetailsMapper {

    @Override
    public AccountDetails toEntity(AccountDetailsDto accountDetails) {
        if ( accountDetails == null ) {
            return null;
        }

        AccountDetails accountDetails1 = new AccountDetails();

        accountDetails1.setPassportId( accountDetails.getPassportId() );
        accountDetails1.setAccountNumber( accountDetails.getAccountNumber() );
        accountDetails1.setBankDetailsId( accountDetails.getBankDetailsId() );
        if ( accountDetails.getMoney() != null ) {
            accountDetails1.setMoney( accountDetails.getMoney().toBigInteger() );
        }
        accountDetails1.setNegativeBalance( accountDetails.getNegativeBalance() );
        accountDetails1.setProfileId( accountDetails.getProfileId() );

        return accountDetails1;
    }

    @Override
    public AccountDetailsDto toDto(AccountDetails accountDetails) {
        if ( accountDetails == null ) {
            return null;
        }

        AccountDetailsDto accountDetailsDto = new AccountDetailsDto();

        accountDetailsDto.setId( accountDetails.getId() );
        accountDetailsDto.setPassportId( accountDetails.getPassportId() );
        accountDetailsDto.setAccountNumber( accountDetails.getAccountNumber() );
        accountDetailsDto.setBankDetailsId( accountDetails.getBankDetailsId() );
        if ( accountDetails.getMoney() != null ) {
            accountDetailsDto.setMoney( new BigDecimal( accountDetails.getMoney() ) );
        }
        accountDetailsDto.setNegativeBalance( accountDetails.getNegativeBalance() );
        accountDetailsDto.setProfileId( accountDetails.getProfileId() );

        return accountDetailsDto;
    }

    @Override
    public List<AccountDetailsDto> toDtoList(List<AccountDetails> accountDetailsList) {
        if ( accountDetailsList == null ) {
            return null;
        }

        List<AccountDetailsDto> list = new ArrayList<AccountDetailsDto>( accountDetailsList.size() );
        for ( AccountDetails accountDetails : accountDetailsList ) {
            list.add( toDto( accountDetails ) );
        }

        return list;
    }

    @Override
    public AccountDetails mergeToEntity(AccountDetails accountDetails, AccountDetailsDto accountDetailsDto) {
        if ( accountDetailsDto == null ) {
            return accountDetails;
        }

        accountDetails.setPassportId( accountDetailsDto.getPassportId() );
        accountDetails.setAccountNumber( accountDetailsDto.getAccountNumber() );
        accountDetails.setBankDetailsId( accountDetailsDto.getBankDetailsId() );
        if ( accountDetailsDto.getMoney() != null ) {
            accountDetails.setMoney( accountDetailsDto.getMoney().toBigInteger() );
        }
        else {
            accountDetails.setMoney( null );
        }
        accountDetails.setNegativeBalance( accountDetailsDto.getNegativeBalance() );
        accountDetails.setProfileId( accountDetailsDto.getProfileId() );

        return accountDetails;
    }
}
