import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { User } from '../user/user.entity';

@Injectable()
export class AuthService {
    constructor(
        @InjectRepository(User)
        private readonly userRepository: Repository<User>
      ) {}

      /*******************************************************
       * Basic Login with credentials
       *******************************************************/
      async login(em, pwd): Promise<User> {
        return await this.userRepository.findOne({email: em, password: pwd});
      }

      async signup(us, em, pwd): Promise<User> {
        const u = new User();
        u.username = us;
        u.email = em;
        u.password = pwd;
        return await this.userRepository.save(u);
      }

}
