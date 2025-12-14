package br.com.LeoChiarelli.codechellaDDD.application.user;

import br.com.LeoChiarelli.codechellaDDD.infrastructure.user.UserEntity;

public interface SendCoupon {

    void sendEmail(UserEntity user);
}
