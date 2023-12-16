'use client'

import { Tweet } from "@/components/tweet";
import { TweetForm } from "@/components/tweet-form";
import { useSession } from "next-auth/react";

export default function HomePage() {

    const {data} = useSession();
    console.log(data);

    return (
        <div className="flex flex-col w-full">
            <div className="border-muted border-x-[1px] border-b-[1px]">
                <TweetForm />
            </div>

            <div className="border-muted border-x-[1px]">
                <Tweet/>
            </div>
        </div>
    );
}
