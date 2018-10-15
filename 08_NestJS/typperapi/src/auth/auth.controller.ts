import { Controller, Res, Post, Body, HttpStatus } from '@nestjs/common';
import { AuthHelper } from './auth.helper';
import { Auth } from './auth.entity';
import { AuthService } from './auth.service';

@Controller('auth')
export class AuthController {
    constructor(private authHelper: AuthHelper, private authService: AuthService) {}

    @Post('/login')
    login(@Res() res, @Body('email') email, @Body('password') password)
    {
        this.authService.login(email, password).then((userResp) => {
          const token = this.authHelper.genToken(userResp);
          // console.log(userResp);
          const responseObject = new Auth(userResp, token);
          res.status(HttpStatus.OK).json(responseObject);
        }).catch(() => {
          res.status(HttpStatus.FORBIDDEN).json({message: 'Login incorrect'});
        });
    }

  @Post('/signup')
  signup(@Res() res, @Body('username') username, @Body('email') email, @Body('password') password )
  {
    this.authService.signup(username, email, password).then((userResp) => {
      const token = this.authHelper.genToken(userResp);
      res.status(HttpStatus.OK).json(token);
    }).catch(() => {
      res.status(HttpStatus.FORBIDDEN).json({mensaje: 'Sign up incorrect'});
    });
  }
}
