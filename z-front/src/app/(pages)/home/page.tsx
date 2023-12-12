import { SplitedContainer } from "@/components/splited-container";
import { Tweet } from "@/components/tweet";
import { TweetForm } from "@/components/tweet-form";

export default function HomePage() {
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
