import Link from "next/link";
import { Avatar, AvatarFallback, AvatarImage } from "../ui/avatar";

export function SplitedContainer({ children }: { children: React.ReactNode }) {

    const profileAvatar = (
        <Avatar>
            <AvatarImage src="http://github.com/doutorwaka.png" />
            <AvatarFallback>D</AvatarFallback>
        </Avatar>
    )

    return (
        <div className="flex w-full p-4">
            <Link href="#" className="px-4">
                {profileAvatar}
            </Link>
            <div className="flex flex-col w-full justify-center m-auto gap-4">
                {children}
            </div>
        </div>
        );
}
