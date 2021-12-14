package com.hosseinzafari.github.app.karak.feature_auth.domain.use_cases

import com.hosseinzafari.github.app.karak.feature_auth.domain.repository.UserAuthRepository
import javax.inject.Inject

/*

@created in 12/12/2021 - 4:58 PM
@project Karak
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

class SignedUserUseCase  @Inject constructor(
    val userAuthRepository: UserAuthRepository
){
    operator fun invoke() = userAuthRepository.userIsSigned()
}