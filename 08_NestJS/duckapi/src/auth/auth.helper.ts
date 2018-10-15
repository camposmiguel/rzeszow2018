import * as jwt from 'jsonwebtoken';

export class AuthHelper {

  /*******************************************************
   * Return a Jwt Token
   *******************************************************/
  genToken(userLogged): any {

    const token = {
      token: jwt.sign({
        user: userLogged,
        exp: Math.round(new Date().getTime() / 1000) + 604800},
      'my-secret')};
    return token.token;
  }
}