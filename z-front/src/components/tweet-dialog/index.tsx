import { TweetForm } from "../tweet-form";
import { Dialog, DialogContent, DialogDescription, DialogHeader, DialogTitle, DialogTrigger } from "../ui/dialog";

export function TweetDialog() {
    return (
        <Dialog>
            <DialogTrigger className="p-2 bg-primary rounded-full w-full">Postar</DialogTrigger>
            <DialogContent className="border-muted max-w-2xl">
                <TweetForm />
            </DialogContent>
        </Dialog>
    );
}
