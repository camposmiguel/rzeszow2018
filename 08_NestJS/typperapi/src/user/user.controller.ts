import { Controller, Get, Res, HttpStatus, Param, Post, Body, Put, Delete, Req } from '@nestjs/common';
import { UserService } from './user.service';

@Controller('user')
export class UserController {
    constructor(
        private usersService: UserService,
    ) {}

    @Get('/all')
    getAllUsers(@Res() res) {
        this.usersService.getAllUsers().then(users => {
          res.status(HttpStatus.OK).json(users);
        });
    }

    @Get('/ranking')
    getRanking(@Res() res) {
        this.usersService.getRanking().then(ranking => {
          res.status(HttpStatus.OK).json(ranking);
        });
    }

    @Get('/:id')
    getUser(@Res() res, @Param('id') id) {
        this.usersService.getUser(id).then(user => {
          res.status(HttpStatus.OK).json(user);
        });
    }

    @Post('/create')
    createUser(@Res() res, @Body('username') username, @Body('email') email, @Body('password') password) {
        this.usersService.createUser(username, email, password).then(result => {
                res.status(HttpStatus.CREATED).json(result);
        }).catch(() => {
            res.status(HttpStatus.FORBIDDEN).json({mensaje: 'Email already exist'});
        });
    }

    @Put('/:id')
    updateUser(@Res() res, @Param('id') id, @Body('username') username, @Body('email') email, @Body('password') password, @Body('ducks') ducks) {
        this.usersService.updateUser(id, username, email, password, ducks).then(result => {
          res.status(HttpStatus.ACCEPTED).json(result);
        });
    }

    @Post('/increase')
    increasePoints(@Req() request, @Res() res, @Body('points') points) {
        this.usersService.updatePoints(request.payload.user.id, points).then(result => {
          res.status(HttpStatus.ACCEPTED).json(result);
        });
    }

    @Delete('/:id')
    deleteUser(@Res() res, @Param('id') id)
    {
        this.usersService.deleteUser(id).then(result => {
          res.status(HttpStatus.ACCEPTED).json(result);
        });
    }

}
