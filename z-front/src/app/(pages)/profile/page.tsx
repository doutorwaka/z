import { Tweet } from "@/components/tweet";
import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar";

export default function ProfilePage() {
    const profile = {
        name: "Doutor Waka",
        login: "doutorwaka",
        image: "http://github.com/doutorwaka.png",
    };

    const avatar = (
        <Avatar className="relative top-20 left-4 h-48 w-48 text-[80px]">
            <AvatarImage src={profile.image} />
            <AvatarFallback>{profile.name.at(0)?.toUpperCase()}</AvatarFallback>
        </Avatar>
    );

    return (
        <div className="flex flex-col w-full border-muted border-[1px] gap-2">
            <div className="flex w-full bg-violet-800">{avatar}</div>
            <div className="mt-20 text-3xl font-bold px-4">{profile.login}</div>
            <div className="font-light px-4">{profile.name}</div>

            <div className="flex gap-8 justify-start px-4 pb-4 border-muted border-b-[1px]">
                <div className="flex gap-2">
                    <span className="font-bold">0</span>
                    <span className="font-light">Seguindo</span>
                </div>

                <div className="flex gap-2">
                    <span className="font-bold">0</span>
                    <span className="font-light">Seguidores</span>
                </div>
            </div>

            <Tweet/>
            <Tweet/>
            <Tweet/>
            <Tweet/>
            <Tweet/>
        </div>
    );
}
