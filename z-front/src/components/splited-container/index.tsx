import Link from "next/link";
import { Avatar, AvatarFallback, AvatarImage } from "../ui/avatar";
import { cn } from "@/utils/utils";

export type SplitedContainerProps = {
    children: React.ReactNode;
    className?: string;
};

export function SplitedContainer({
    children,
    className = "",
}: SplitedContainerProps) {
    const profileAvatar = (
        <Avatar>
            <AvatarImage src="http://github.com/doutorwaka.png" />
            <AvatarFallback>D</AvatarFallback>
        </Avatar>
    );

    return (
        <div className={cn("flex w-full p-4", className)}>
            <Link href="#" className="px-4">
                {profileAvatar}
            </Link>
            <div className="flex flex-col w-full justify-center m-auto gap-4">
                {children}
            </div>
        </div>
    );
}
