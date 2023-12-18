"use client";

import { Tweet } from "@/components/tweet";
import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar";
import { services } from "@/services";
import { GetProfileResponseDto } from "@/services/profile";
import { useParams } from "next/navigation";
import { useEffect, useState } from "react";

export default function ProfilePage() {
    const { profile } = useParams();

    const [profileData, setProfileData] = useState<GetProfileResponseDto>();

    useEffect(() => {
        services.profile
            .get({ profile: profile.toString() })
            .then((response) => {
                setProfileData(response);
            });
    }, [profile]);

    const profileAvatarSrc = `http://github.com/${profile}.png`;

    const avatar = (
        <Avatar className="relative top-20 left-4 h-48 w-48 text-[80px]">
            <AvatarImage src={profileAvatarSrc} />
            <AvatarFallback>
                {profile.at(0)?.toUpperCase()}
            </AvatarFallback>
        </Avatar>
    );

    return (
        <div className="flex flex-col w-full border-muted border-[1px] gap-2">
            <div className="flex w-full bg-violet-800">{avatar}</div>
            <div className="mt-20 text-3xl font-bold px-4">
                {profile}
            </div>
            <div className="font-light px-4">{profileData?.name}</div>

            <div className="flex gap-8 justify-start px-4 pb-4 border-muted border-b-[1px]">
                <div className="flex gap-2">
                    <span className="font-bold">{profileData?.followed.length}</span>
                    <span className="font-light">Seguindo</span>
                </div>

                <div className="flex gap-2">
                    <span className="font-bold">0</span>
                    <span className="font-light">Seguidores</span>
                </div>
            </div>

            <Tweet />
            <Tweet />
            <Tweet />
            <Tweet />
            <Tweet />
        </div>
    );
}
