package com.bank.account.mapper;

import com.bank.account.dto.AccountDetailsDto;
import com.bank.account.entity.AccountDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;


@Mapper(componentModel = "spring")
public interface AccountDetailsMapper {

    @Mapping(target = "id", ignore = true)
    AccountDetails toEntity(AccountDetailsDto accountDetails);

    AccountDetailsDto toDto(AccountDetails accountDetails);

    List<AccountDetailsDto> toDtoList(List<AccountDetails> accountDetailsList);

    @Mapping(target = "id", ignore = true)
    AccountDetails mergeToEntity(@MappingTarget AccountDetails accountDetails, AccountDetailsDto accountDetailsDto);

}