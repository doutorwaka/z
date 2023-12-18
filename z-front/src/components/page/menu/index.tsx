import Link from "next/link";
import ZLogo from "@/images/z.png";
import Image from "next/image";
import { HomeIcon } from "lucide-react";
import { TweetDialog } from "@/components/tweet-dialog";
import { LogoutButton } from "./logout-button";
import { ProfileButton } from "./perfil-button";

export function PageMenu() {
    return (
        <nav className="flex flex-auto m-auto w-full px-4">
            <div className="flex flex-col gap-2">
                <Link
                    href="/"
                    className="flex max-w-[64px] gap-4 rounded-full p-4 hover:bg-menu-hover text-lg"
                >
                    <div>
                        <Image src={ZLogo} width={100} height={100} alt="Z" />
                    </div>
                </Link>

                <Link
                    href="/home"
                    className="flex gap-4 rounded-full p-4 hover:bg-menu-hover text-lg"
                >
                    <div>
                        <HomeIcon />
                    </div>
                    <div>Home</div>
                </Link>

                <ProfileButton />

                <LogoutButton />

                <div className="m-auto w-full">
                    <TweetDialog />
                </div>
            </div>
        </nav>
    );
}
