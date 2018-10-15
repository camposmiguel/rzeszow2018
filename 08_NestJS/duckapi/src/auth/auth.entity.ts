import { User } from '../user/user.entity';

export class Auth {
    token: string;
    username: string;
    email: string;
    ducks: number;

    constructor(user: User, token: string) {
        // Object.assign(this, user);
        this.token = token;
        this.username = user.username;
        this.email = user.email;
        this.ducks = user.ducks;
    }
  }
