import {Component, NgModule, OnInit, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";
import {PostService} from "../../service/post.service";
import {Post} from "../../model/post.model";
import {Router} from "@angular/router";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {User} from "../../model/user.model";
import {UserService} from "../../service/user.service";

@Component({
    selector: 'app-posts-add',
    templateUrl: './posts-add.component.html',
    styleUrls: ['./posts-add.component.css']
})

@NgModule({
    imports: [BrowserAnimationsModule]
})
export class PostsAddComponent implements OnInit {
    @ViewChild('f') addPostForm: NgForm;
    currentUser = {} as User;

    constructor(private postService: PostService, private userService: UserService, private router: Router) {
    }

    ngOnInit() {
        this.userService.getCurrentUser().subscribe(
            (data: User) => {
                this.currentUser = data;
                console.log(this.currentUser);
            },
            (error) => console.log(error)
        );
    }

    onAddPost(files: any) {
        const value = this.addPostForm.value;
        const newPost = new Post(value.title, value.content, this.addCategories(), this.currentUser);
        let file: File = files[0];
        console.log(file);
        this.postService.savePost(newPost, file);
        this.router.navigate(['/posts-list']);
    }

    private addCategories() {
        let newCategories: string[] = [];

        if (this.addPostForm.value.categories.tarantulas === true) {
            newCategories.push('TARANTULAS');
        }

        else if (this.addPostForm.value.categories.care === true) {
            newCategories.push('CARE');
        }

        else if (this.addPostForm.value.categories.help === true) {
            newCategories.push('HELP');
        }

        else if (this.addPostForm.value.categories.moult === true) {
            newCategories.push('MOULT');
        }

        else if (this.addPostForm.value.categories.feeding === true) {
            newCategories.push('FEEDING');
        }
        else{
            newCategories.push('OTHER')
        }



        return newCategories;
    }

}
